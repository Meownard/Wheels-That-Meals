package com.merrymeal.mealsonwheels_backend.service;

import com.merrymeal.mealsonwheels_backend.dto.LoginDTO;
import com.merrymeal.mealsonwheels_backend.dto.RegisterDTO;
import com.merrymeal.mealsonwheels_backend.dto.UserDTO;
import com.merrymeal.mealsonwheels_backend.model.*;
import com.merrymeal.mealsonwheels_backend.repository.RoleRepository;
import com.merrymeal.mealsonwheels_backend.repository.UserRepository;
import com.merrymeal.mealsonwheels_backend.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.io.IOException;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public String login(LoginDTO loginDTO) {
        // Authenticate the user first
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),
                        loginDTO.getPassword()));

        // Fetch user by email
        User user = userRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check approval status
        if (!user.isApproved()) {
            throw new RuntimeException("Account is pending admin approval.");
        }

        // Generate token if approved
        return jwtTokenProvider.generateToken(loginDTO.getEmail());
    }

    @Override
    public UserDTO register(RegisterDTO registerDTO) {
        if (userRepository.findByUsername(registerDTO.getUsername()).isPresent()) {
            throw new RuntimeException("Username already taken");
        }
        if (userRepository.findByEmail(registerDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        Role role = roleRepository.findByName(registerDTO.getRoleName())
                .orElseThrow(() -> new RuntimeException("Role not found: " + registerDTO.getRoleName()));

        String encodedPassword = passwordEncoder.encode(registerDTO.getPassword());

        User user = createUserInstance(registerDTO, role, encodedPassword);

        // approved true only if admin role
        user.setApproved(role.getName().equalsIgnoreCase("ROLE_ADMIN"));

        User savedUser = userRepository.save(user);

        return mapToDTO(savedUser);
    }

@Autowired
private LocationIQService locationIQService;

private User createUserInstance(RegisterDTO dto, Role role, String encodedPassword) {
    String roleName = role.getName().toUpperCase();

    switch (roleName) {
        case "ROLE_ADMIN":
            return new Admin(dto.getUsername(), dto.getPhoneNumber(), dto.getEmail(), encodedPassword, true, role);
        
            case "ROLE_MEMBER":
                double lat, lon;
                try {
                    double[] coords = locationIQService.getCoordinatesFromAddress(dto.getAddress());
                    lat = coords[0];
                    lon = coords[1];
                } catch (IOException e) {
                    throw new RuntimeException("Failed to fetch coordinates for member address: " + e.getMessage());
                }

                return new Member(
                        dto.getUsername(),
                        dto.getPhoneNumber(),
                        dto.getEmail(),
                        encodedPassword,
                        false,
                        role,
                        dto.getDietaryRestriction(),
                        dto.getAddress(),
                        lat,
                        lon
                );

        case "ROLE_VOLUNTEER":
            return new Volunteer(dto.getUsername(), dto.getPhoneNumber(), dto.getEmail(), encodedPassword, false, role,
                    dto.getAvailability(), dto.getServices());

        case "ROLE_CAREGIVER":
            return new Caregiver(dto.getUsername(), dto.getPhoneNumber(), dto.getEmail(), encodedPassword, false, role,
                    dto.getQualificationAndSkills());

        case "ROLE_RIDER":
            return new Rider(dto.getUsername(), dto.getPhoneNumber(), dto.getEmail(), encodedPassword, false, role,
                    dto.getDriverLicense());

        case "ROLE_PARTNER":
        double partnerLat;
        double partnerLong;
        try {
            double[] coords = locationIQService.getCoordinatesFromAddress(dto.getCompanyAddress());
            partnerLat = coords[0];  // latitude
            partnerLong = coords[1]; // longitude
        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch coordinates for company address: " + e.getMessage());
        }

        return new Partner(
                dto.getUsername(),
                dto.getPhoneNumber(),
                dto.getEmail(),
                encodedPassword,
                false,
                role,
                dto.getCompanyName(),
                dto.getCompanyDes(),
                dto.getCompanyAddress(),
                partnerLat,
                partnerLong
        );

        case "ROLE_SUPPORTER":
            return new Supporter(dto.getUsername(), dto.getPhoneNumber(), dto.getEmail(), encodedPassword, false, role,
                    dto.getSupportType(), dto.getSupdescription());

        case "ROLE_DONOR":
            return new Donor(dto.getUsername(), dto.getPhoneNumber(), dto.getEmail(), encodedPassword, true, role,
                    dto.getDonorType(), dto.getDonationAmount());

        default:
            throw new RuntimeException("Unsupported role for registration: " + roleName);
    }
}



    private UserDTO mapToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setEmail(user.getEmail());
        dto.setApproved(user.isApproved());
        dto.setUserType(user.getUserType());
        dto.setRoleName(user.getRole() != null ? user.getRole().getName() : null);
        return dto;
    }
}
