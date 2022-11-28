package pl.coderslab.charity.Service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.Repositories.TokenRepository;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;

@Service
public class TokenService {
    public final TokenRepository tokenRepository;

    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }
    public String[] alltokenvalues(){
        List<String> tokens=tokenRepository.tokensvalue();
        Iterator<String> iterator=tokens.iterator();
        int howmany=0;
        while (iterator.hasNext()){
            String next= iterator.next();
            howmany++;
        }
        String[] tokenstoarray=new String[howmany];
        int now=0;
        Iterator<String> iterator2=tokens.iterator();
        while (iterator2.hasNext()){
            tokenstoarray[now]=iterator2.next();
        }
        return tokenstoarray;
    }
}
