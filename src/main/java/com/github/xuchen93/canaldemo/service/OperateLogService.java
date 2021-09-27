package com.github.xuchen93.canaldemo.service;

import com.github.xuchen93.canaldemo.entity.OperateLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

/**
 * @author xuchen.wang
 * @date 2021/9/27
 */
@Slf4j
@Service
@CanalTable("operate_log")
public class OperateLogService implements EntryHandler<OperateLog> {
	public void insert(OperateLog t) {
		log.info(t.toString());
	}

	public void update(OperateLog before, OperateLog after) {
		log.info(before.toString());
		log.info(after.toString());
	}

	public void delete(OperateLog t) {
		log.info(t.toString());
	}

}
