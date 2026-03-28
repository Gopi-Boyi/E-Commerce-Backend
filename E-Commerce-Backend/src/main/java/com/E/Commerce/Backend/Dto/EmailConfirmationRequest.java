package com.E.Commerce.Backend.Dto;

import lombok.Data;

@Data
public class EmailConfirmationRequest
{
    private String email;
    private String confirmationCode;
}
