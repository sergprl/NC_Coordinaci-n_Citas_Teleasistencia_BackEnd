INSERT INTO USERS (email, password, role) VALUES ('admin@gmail.com', 'password', 'ADMIN');
INSERT INTO USERS (email, password, role, name, last_name, gender)
    VALUES ('patient@gmail.com', 'password', 'PATIENT', 'Pedro', 'Gomez', 'MASCULINO');
INSERT INTO USERS (email, password, role, name, last_name, gender)
    VALUES ('doctor@gmail.com', 'password', 'DOCTOR', 'Ximena', 'Perez', 'FEMENINO');

INSERT INTO PATIENT (user_id, address) VALUES (2, 'Somewhere in the world');
INSERT INTO DOCTOR (user_id, license_number) VALUES (3, 'ABCD123');