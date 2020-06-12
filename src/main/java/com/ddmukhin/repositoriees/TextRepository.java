package com.ddmukhin.repositoriees;

import com.ddmukhin.models.Text;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextRepository extends JpaRepository<Text, Long> {
}
