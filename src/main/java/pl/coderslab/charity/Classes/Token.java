package pl.coderslab.charity.Classes;

import lombok.Data;

import javax.persistence.*;
import java.util.Random;

@Data
@Entity
@Table(name = "Token")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "token",unique = true)
    private String token;
    @Column(name = "activetoken")
    private boolean activetoken;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Token(Long id, String token, boolean activetoken,User user) {
        this.id = id;
        this.token = token;
        this.activetoken = activetoken;
        this.user = user;
    }

    public Token() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isActivetoken() {
        return activetoken;
    }

    public void setActivetoken(boolean activetoken) {
        this.activetoken = activetoken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String generatetoken(){

            char[] str = new char[100];
            for (int i = 0; i < 5; i++)
            {
                str[i] = (char) (((int)(Math.random() * 26)) + (int)'a');
            }
            for (int i = 5; i <10; i++)
            {
                str[i] = (char) (((int)(Math.random() * 26)) + (int)'A');
            }
            return (new String(str, 0, 10));
    }
    public String generalongertetoken(){

        char[] str = new char[100];
        char[] str1={'0','1','2','3','4','5','6','7','8','9'};
        for (int i = 0; i < 5; i++)
        {
            str[i] = (char) (((int)(Math.random() * 26)) + (int)'a');
        }
        for (int i = 5; i <10; i++)
        {
            str[i] = (char) (((int)(Math.random() * 26)) + (int)'A');
        }
        Random random=new Random();
        for (int i = 10; i <15; i++)
        {
            int a=random.nextInt(10);
            while (a<0 || a>9){
                a=random.nextInt(10);
            }
            str[i] =str1[a];
        }
        return (new String(str, 0, 15));
    }
}
