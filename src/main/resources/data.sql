INSERT INTO USERS (email, password, role) VALUES ('admin@gmail.com', '$2a$12$3TKcJRSt7AKm3DP3GjTT9uG930mf5PuiFmeS9Pxq7OS7c8JyL6O26', 'ADMIN');
INSERT INTO USERS (email, password, role, name, last_name, gender)
    VALUES ('patient@gmail.com', '$2a$12$3TKcJRSt7AKm3DP3GjTT9uG930mf5PuiFmeS9Pxq7OS7c8JyL6O26', 'PATIENT', 'Pedro', 'Gomez', 'MASCULINO');
INSERT INTO USERS (email, password, role, name, last_name, gender)
    VALUES ('doctor@gmail.com', '$2a$12$3TKcJRSt7AKm3DP3GjTT9uG930mf5PuiFmeS9Pxq7OS7c8JyL6O26', 'DOCTOR', 'Ximena', 'Perez', 'FEMENINO');

INSERT INTO PATIENT (user_id, address) VALUES (2, 'Somewhere in the world');
INSERT INTO DOCTOR (user_id, license_number) VALUES (3, 'ABCD123');