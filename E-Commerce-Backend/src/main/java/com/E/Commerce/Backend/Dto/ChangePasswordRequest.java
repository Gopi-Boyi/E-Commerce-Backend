package com.E.Commerce.Backend.Dto;

import lombok.Data;

@Data
public class ChangePasswordRequest
{
    private String currentPassword;
    private String newPassword;
}
