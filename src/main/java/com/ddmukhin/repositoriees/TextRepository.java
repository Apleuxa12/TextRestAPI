package com.ddmukhin.repositoriees;

import com.ddmukhin.models.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TextRepository extends JpaRepository<Text, Long> {

    @Query("SELECT t FROM Text t WHERE t.theme = :theme")
    List<Text> findByTheme(@Param("theme") String theme);

}
