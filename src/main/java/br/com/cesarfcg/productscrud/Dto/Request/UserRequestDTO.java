package br.com.cesarfcg.productscrud.Dto.Request;

import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(@NotBlank String name, @NotBlank String login, @NotBlank String password) {
}
