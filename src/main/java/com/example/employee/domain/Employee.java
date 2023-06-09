package com.example.employee.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@DynamoDBTable(tableName = "employee")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee  {

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    private String id;

    @DynamoDBAttribute
    private String firstName;

    @DynamoDBAttribute
    private String lastName;

    @DynamoDBAttribute
    private String number;

    @DynamoDBAttribute
    private String email;

    @DynamoDBAttribute
    private String department;

    @DynamoDBAttribute
    private double salary;
}

