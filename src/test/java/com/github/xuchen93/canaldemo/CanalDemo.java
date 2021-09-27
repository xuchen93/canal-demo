package com.github.xuchen93.canaldemo;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.Message;
import lombok.SneakyThrows;

import java.net.InetSocketAddress;

/**
 * @author xuchen.wang
 * @date 2021/9/27
 */
public class CanalDemo {

	@SneakyThrows
	public static void main(String[] args) {
		CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress("114.67.100.84", 11111), "example", "", "");
		try {
			connector.connect();
			connector.subscribe(".*\\..*");
			connector.rollback();
			while (true){
				Message message = connector.getWithoutAck(3); // 获取指定数量的数据
				long batchId = message.getId();
				if (batchId == -1 || message.getEntries().isEmpty()) {
					Thread.sleep(1000);
					continue;
				}
				 System.out.println(message.getEntries());
				connector.ack(batchId);// 提交确认，消费成功，通知server删除数据
				// connector.rollback(batchId);// 处理失败, 回滚数据，后续重新获取数据
			}
		} finally {
			connector.disconnect();
		}

	}
}
