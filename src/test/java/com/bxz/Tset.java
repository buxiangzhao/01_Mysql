package com.bxz;

import com.bxz.enums.MailContentTypeEnum;
import com.bxz.utils.MailSender;
import org.junit.Test;

import javax.swing.text.html.HTML;
import java.util.ArrayList;

/**
 * Created by SQ_BXZ on 2018-04-12.
 */
public class Tset {

	@Test
	public void sendMail() throws Exception {
//		new MailSender().content("发送内容")
//				.contentType(MailContentTypeEnum.TEXT)
//				.title("发送测试")
//				.targets(new ArrayList<String>() {
//					{
//						add("1647623919@qq.com");
//					}
//				})
//				.send();
		System.out.println("ddddddd");
		System.out.println(MailContentTypeEnum.HTML.getValue());
	}
}
