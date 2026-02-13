package com.vexor.auth.domain.record;

import java.util.List;

public record ParsedJwt(String subject, List<String> roles, String type) {}