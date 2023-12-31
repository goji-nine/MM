package org.me.domain.relay.dto;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BoardDto {

	private int bno;     
	
    private String title;      
    
    private String content;    
    
    private String userId; 
    
    private String username;    

    private Date regdate;      
    
    private Date updatedate;       	
    
}