package com.taobao.pamirs.schedule;

/**
 * �������������ӿ�
 *
 * @author xuannan
 */
public interface IScheduleTaskDealMulti<T> extends IScheduleTaskDeal<T> {

  /**
   * ִ�и������������顣��Ϊ���Ͳ�֧��new ���飬ֻ�ܴ���OBJECT[]
   *
   * @param tasks ��������
   * @param ownSign ��ǰ��������
   */
  public boolean execute(T[] tasks, String ownSign) throws Exception;
}
