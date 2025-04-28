CREATE DATABASE IF NOT EXISTS mealsonwheels_db;

USE mealsonwheels_db;

CREATE TABLE members (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  address VARCHAR(255),
  contact VARCHAR(50),
  dietary_restrictions TEXT
);

-- Add more tables later: caregivers, partners, volunteers, donations, menus, deliveries, etc.
