package com.example.lr_4.repositories;

import com.example.lr_4.models.MailingRuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.UUID;

public interface MailingRulesRepository extends JpaRepository<MailingRuleEntity, UUID> {

    @Query(value = "select email from mailing_rules where table_name=:name", nativeQuery = true)
    List<String> findEmailByTableName(@Param("name") String tableName);

}
