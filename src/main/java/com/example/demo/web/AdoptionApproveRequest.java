package com.example.demo.web;

public record AdoptionApproveRequest(Long applicationId, boolean feePaid) {
}