package com.app.agendamentoConsultaApi.exception;

public class HorarioIndisponivelException extends RuntimeException {

    public HorarioIndisponivelException (String message){
        super(message);
    }
}
