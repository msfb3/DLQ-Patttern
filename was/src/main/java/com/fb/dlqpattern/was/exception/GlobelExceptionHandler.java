package com.fb.dlqpattern.was.exception;


import de.muenchen.oss.wahllokalsystem.wls.common.exception.errorhandler.AbstractExceptionHandler;
import de.muenchen.oss.wahllokalsystem.wls.common.exception.rest.model.DTOMapper;
import de.muenchen.oss.wahllokalsystem.wls.common.exception.rest.model.WlsExceptionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobelExceptionHandler extends AbstractExceptionHandler {

    @Value("${service.info.oid}")
    String serviceOid;

    public GlobelExceptionHandler(DTOMapper dtoMapper) {
        super(dtoMapper);
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<WlsExceptionDTO> handleException(Exception throwable) {
        return createResponse(getWahlExceptionDTO(throwable));
    }


    @Override
    protected String getService() {
        return this.serviceOid;
    }
}
