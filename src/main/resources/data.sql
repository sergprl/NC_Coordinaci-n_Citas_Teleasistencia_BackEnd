INSERT INTO USERS (email, password, role) VALUES ('admin@gmail.com', '$2a$12$3TKcJRSt7AKm3DP3GjTT9uG930mf5PuiFmeS9Pxq7OS7c8JyL6O26', 'ADMIN');

INSERT INTO USERS (email, password, role, name, last_name, gender, phone)
    VALUES ('patient_pedro@gmail.com', '$2a$12$3TKcJRSt7AKm3DP3GjTT9uG930mf5PuiFmeS9Pxq7OS7c8JyL6O26', 'PATIENT', 'Pedro', 'Gomez', 'MASCULINO', 2225551234);
INSERT INTO PATIENT (user_id, address, birth_date) VALUES (2, 'Somewhere in the world', '2018-03-15');
INSERT INTO USERS (email, password, role, name, last_name, gender, phone)
    VALUES ('patient_mateo@gmail.com', '$2a$12$3TKcJRSt7AKm3DP3GjTT9uG930mf5PuiFmeS9Pxq7OS7c8JyL6O26', 'PATIENT', 'Mateo', 'Ramirez', 'MASCULINO', 2229876543);
INSERT INTO PATIENT (user_id, address, birth_Date) VALUES (3, 'Somewhere in the world', '2005-07-22');
INSERT INTO USERS (email, password, role, name, last_name, gender, phone)
    VALUES ('patient_valentina@gmail.com', '$2a$12$3TKcJRSt7AKm3DP3GjTT9uG930mf5PuiFmeS9Pxq7OS7c8JyL6O26', 'PATIENT', 'Valentina', 'Herrera', 'FEMENINO', 2223339876);
INSERT INTO PATIENT (user_id, address, birth_Date) VALUES (4, 'Somewhere in the world', '1996-12-03');


INSERT INTO USERS (email, password, role, name, last_name, gender, phone)
    VALUES ('doctora_ximena@gmail.com', '$2a$12$3TKcJRSt7AKm3DP3GjTT9uG930mf5PuiFmeS9Pxq7OS7c8JyL6O26', 'DOCTOR', 'Ximena', 'Perez', 'FEMENINO', 2227774321);
INSERT INTO DOCTOR (user_id, license_number, specialty) VALUES (5, 'ABCD123', 'PSIQUIATRIA');
INSERT INTO USERS (email, password, role, name, last_name, gender, phone)
    VALUES ('doctor_santiago@gmail.com', '$2a$12$3TKcJRSt7AKm3DP3GjTT9uG930mf5PuiFmeS9Pxq7OS7c8JyL6O26', 'DOCTOR', 'Santiago', 'Morales', 'MASCULINO', 2221118765);
INSERT INTO DOCTOR (user_id, license_number, specialty) VALUES (6, 'ABCD456', 'PEDIATRIA');
INSERT INTO USERS (email, password, role, name, last_name, gender, phone)
    VALUES ('doctora_sofia@gmail.com', '$2a$12$3TKcJRSt7AKm3DP3GjTT9uG930mf5PuiFmeS9Pxq7OS7c8JyL6O26', 'DOCTOR', 'Sofia', 'Rodriguez', 'FEMENINO', 2224442345);
INSERT INTO DOCTOR (user_id, license_number, specialty) VALUES (7, 'ABCD789', 'CIRUGIA');