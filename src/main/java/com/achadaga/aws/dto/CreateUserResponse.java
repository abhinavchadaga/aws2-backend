package com.achadaga.aws.dto;

import com.achadaga.aws.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateUserResponse {
    private String msg;
    private User user;
}
