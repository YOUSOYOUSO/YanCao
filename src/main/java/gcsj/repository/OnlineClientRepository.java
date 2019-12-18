package gcsj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gcsj.entity.OnlineClient;

import java.util.List;

public interface OnlineClientRepository extends JpaRepository<OnlineClient, Long> {

    List<OnlineClient> findClientByIp(String ip);


}