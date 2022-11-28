package pl.coderslab.charity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.Classes.Token;

import java.util.List;

public interface TokenRepository extends JpaRepository<Token, Long>{
    @Query("SELECT t.activetoken FROM Token t")
    List<String> tokensvalue();
    @Query("SELECT t FROM Token t where t.token=:token")
    Token tokenofuser(String token);
}