package org.geekster;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Email Automation !!!");

        MailHandle mailHandler = new MailHandle();
        mailHandler.sendMail();
    }
}