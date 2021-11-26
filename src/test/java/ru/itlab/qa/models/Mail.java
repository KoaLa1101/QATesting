package ru.itlab.qa.models;

import lombok.Data;

@Data
public class Mail {
    public String receiver;
    public String theme;
    public String text;
}
