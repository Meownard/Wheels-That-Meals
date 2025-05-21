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

import java.math.BigDecimal;
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
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginDTO.getEmail(),
                loginDTO.getPassword()
            )
        );
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

    private User createUserInstance(RegisterDTO dto, Role role, String encodedPassword) {
        String roleName = role.getName().toUpperCase();

        switch (roleName) {
            case "ROLE_ADMIN":
                return new Admin(dto.getUsername(), dto.getPhoneNumber(), dto.getEmail(), encodedPassword, true, role);

            case "ROLE_MEMBER":
                return new Member(dto.getUsername(), dto.getPhoneNumber(), dto.getEmail(), encodedPassword, false, role,
                        "DEFAULT_ADDRESS", "DEFAULT_LOCATION");

            case "ROLE_VOLUNTEER":
                return new Volunteer(dto.getUsername(), dto.getPhoneNumber(), dto.getEmail(), encodedPassword, false, role,
                        "Flexible", "Meal Packing");

            case "ROLE_CAREGIVER":
                return new Caregiver(dto.getUsername(), dto.getPhoneNumber(), dto.getEmail(), encodedPassword, false, role,
                        "Qualified Nurse");

            case "ROLE_RIDER":
                return new Rider(dto.getUsername(), dto.getPhoneNumber(), dto.getEmail(), encodedPassword, false, role,
                        "DL-0000000");

            case "ROLE_PARTNER":
                return new Partner(dto.getUsername(), dto.getPhoneNumber(), dto.getEmail(), encodedPassword, false, role,
                        "Org Name", "Description", "Address");

            case "ROLE_SUPPORTER":
                return new Supporter(dto.getUsername(), dto.getPhoneNumber(), dto.getEmail(), encodedPassword, false, role,
                        "Advocate", "Supports community events");

            case "ROLE_DONOR":
                return new Donor(dto.getUsername(), dto.getPhoneNumber(), dto.getEmail(), encodedPassword, false, role,
                        "Individual", BigDecimal.ZERO);

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
