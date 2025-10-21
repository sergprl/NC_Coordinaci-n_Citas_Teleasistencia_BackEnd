package com.nocountry.teleasistencia.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
//
//    private final UserService userService;
//
//    private final PatientService patientService;
//
//    private final DoctorService doctorService;
//
//    @GetMapping
//    public List<User> list(){
//        return userService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> get(@PathVariable Long id){
//        Optional<User> user = userService.findById(id);
//        return user.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<?> create(@Valid @RequestBody RequestUserDTO userDTO, BindingResult result){
//        if (result.hasErrors()){
//            return validation(result);
//        }
//        if (userService.existsUsername(userDTO.getEmail())){
//            return ResponseEntity.badRequest().body("El email ya existe");
//        }
//
//
//        User user;
//        if (userDTO.getRole().equalsIgnoreCase("PATIENT")){
//            Patient patient = (Patient) getUser(userDTO, userDTO.getRole());
//            patient.setAddress(userDTO.getAddress());
//            patient.setBirthDate(LocalDate.parse(userDTO.getBirthDate()));
//            patient.setGender(userDTO.getGenre());
//            user = patientService.save(patient);
//        }else if (userDTO.getRole().equalsIgnoreCase("DOCTOR")) {
//            Doctor doctor = (Doctor) getUser(userDTO, userDTO.getRole());
//            doctor.setSpecialty(userDTO.getSpecialty());
//            doctor.setLicenseNumber(userDTO.getLicenseNumber());
//            user = doctorService.save(doctor);
//        }else {
//            return ResponseEntity.badRequest().body("El rol invalido");
//        }
//        ResponseUserDTO  response = new ResponseUserDTO(user.getId(), user.getEmail(), userDTO.getRole());
//        return ResponseEntity.status(201).body(response);
//    }
//
//    private static User getUser(RequestUserDTO userDTO ,String role) {
//        User user;
//        if (role.equalsIgnoreCase("PATIENT")){
//            user = new Patient();
//        }else if (role.equalsIgnoreCase("DOCTOR")) {
//            user = new Doctor();
//        }else {
//            throw new IllegalArgumentException("Rol invalido");
//        }
//        user.setName(userDTO.getName());
//        user.setEmail(userDTO.getEmail());
//        user.setPassword(userDTO.getPassword());
//        user.setPhone(userDTO.getPhone());
//        return user;
//    }
//
//    private static ResponseEntity<?> validation(BindingResult result){
//        Map<String, String> errors = new HashMap<>();
//        result.getFieldErrors().forEach(err -> {
//            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
//        });
//        return ResponseEntity.badRequest().body(errors);
//    }

}
