package br.com.cesarfcg.productscrud.Dto.Request;

import jakarta.validation.constraints.NotBlank;

public record RegisterRequestDTO(@NotBlank String login,@NotBlank  String password,@NotBlank  String name ) {
}
