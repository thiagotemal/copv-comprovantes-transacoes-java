package br.com.temal.pa.rest.controller;


import br.com.temal.pa.rest.model.DataPresenter;


import br.com.temal.pa.rest.repository.PersonRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/transactions")
@Api(value = "/v1/transactions")
public class BillsController {

    @Autowired
    private PersonRepository personService;



    @ApiOperation("obter comprovante")
    @ApiResponses(
            @ApiResponse(
                    code = 200,
                    message = "Ok",
                    response = DataPresenter.class))
    @RequestMapping(method = RequestMethod.GET,path = "/receipt/{nsu}" )
    @ResponseBody
    public ResponseEntity Find(@ApiParam(value = "nsu",required=true) @PathVariable("nsu") String nsu) {

        try {
            var exists = this.personService.findById(nsu);

            if (exists.isPresent()) {

                return  ResponseEntity.ok().body(DataPresenter.builder().data(exists.get()).build());

            } else {
                return new ResponseEntity<>(new HashMap<>().put("message", "Não encontrado"),
                        HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new HashMap<>().put("message", "Ocorreu na requisição"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
