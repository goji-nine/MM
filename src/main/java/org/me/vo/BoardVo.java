package org.me.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVo {

	private int bno;            // �Խñ� ��ȣ
    private String title;       // �Խñ� ����
    private String content;     // �Խñ� ����
    private String writer;      // �Խñ� �ۼ���
    private Date regdate;       // �Խñ� �ۼ����� util.Date
    private Date updatedate;        // �Խñ� ��ȸ��
    
    // toString()
    @Override
    public String toString() {
        return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
                + regdate + ", updatedate=" + updatedate + "]";
    }
}
