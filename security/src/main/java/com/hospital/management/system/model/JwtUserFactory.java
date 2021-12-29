package com.hospital.management.system.model;


public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(EmployeeModel user) {
        return new JwtUser(
                user.getId(),
                user.getUserName(),
                null,
                null,
                null,

                user.getPassword(),
                null,
                true,
                null
        );
    }

}
