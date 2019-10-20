package com.healthelp.patient.controller;

import com.healthelp.patient.model.documents.Patient;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/v1")
public interface PatientController {

    @GetMapping(path="/patients",produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Flux<Patient>> getPatients();

    @GetMapping(path="/patients/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Mono<Patient>> getPatientsById(@PathVariable("id") String id);


}




/*
*





    @ApiOperation(value = "Get patient by name", notes="Get patient request.")
    @GetMapping(path="/api/patient/name/{name}/userId/{userId}",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            value = "JWT Token",
            required = true,
            dataType = "string",
            paramType = "header") })
    ResponseEntity<Resources<PatientDTO>> getPatientsByName(@ApiParam(name="Patient name request", value="Patient name",required = true)@PathVariable("name")String name,
                                                            @ApiParam(name="User id request", value="User id",required = true)@PathVariable("userId") Integer id
    )throws RuntimeException;



    @ApiOperation(value="Insert patient ",notes="Insert patient request.")
    @PostMapping(path="/api/patient", produces = { MediaType.APPLICATION_JSON_VALUE },consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            value = "JWT Token",
            required = true,
            dataType = "string",
            paramType = "header") })
    ResponseEntity<Resource<PatientDTO>> insertPatient(@ApiParam(name="Patient request", value="Patient request",required = true)@RequestBody Patient patient);


    @ApiOperation(value="Update patient",notes="Update patient request.")
    @PutMapping(path="/api/patient", produces = { MediaType.APPLICATION_JSON_VALUE },consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            value = "JWT Token",
            required = true,
            dataType = "string",
            paramType = "header") })
    ResponseEntity<Resource<PatientDTO>> updatePatient(@ApiParam(name="Patient request", value="Patient request",required = true)@RequestBody Patient patient);

    @ApiOperation(value="Delete patient",notes="Delete patient request.")
    @DeleteMapping(path="/api/patient/{id}",produces = { MediaType.APPLICATION_JSON_VALUE },consumes = { MediaType.ALL_VALUE })
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            value = "JWT Token",
            required = true,
            dataType = "string",
            paramType = "header")})
    ResponseEntity<Resource<Boolean>> deletePatient(@ApiParam(name="Patient id request", value="Patient id", required = true,defaultValue = "0")@PathVariable("id") Integer id);


}

*
*
* */
