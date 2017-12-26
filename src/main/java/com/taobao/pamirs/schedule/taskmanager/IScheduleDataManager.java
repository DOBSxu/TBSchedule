package com.taobao.pamirs.schedule.taskmanager;

import java.util.List;

import com.taobao.pamirs.schedule.TaskItemDefine;


/**
 * �����������Ŀͻ��˽ӿڣ������л������ݿ��ʵ�֣������л���ConfigServer��ʵ��
 *
 * @author xuannan
 */
public interface IScheduleDataManager {

  public long getSystemTime();

  /**
   * ����װ�ص�ǰserver��Ҫ��������ݶ���
   *
   * @param taskType ��������
   * @param uuid ��ǰserver��UUID
   */
  public List<TaskItemDefine> reloadDealTaskItem(String taskType, String uuid) throws Exception;

  /**
   * װ�����е����������Ϣ
   */
  public List<ScheduleTaskItem> loadAllTaskItem(String taskType) throws Exception;

  /**
   * �ͷ��Լ��ѳ֣���������Ķ���
   */
  public void releaseDealTaskItem(String taskType, String uuid) throws Exception;

  /**
   * ��ȡһ���������͵Ĵ����������
   */
  public int queryTaskItemCount(String taskType) throws Exception;

  /**
   * װ���������������Ϣ
   */
  public ScheduleTaskType loadTaskTypeBaseInfo(String taskType) throws Exception;

  /**
   * ����Ѿ����ڵĵ��ȷ�������Ϣ
   */
  public int clearExpireScheduleServer(String taskType, long expireTime) throws Exception;

  /**
   * ���������Ϣ���������Ѿ������ڵ�ʱ��
   */
  public int clearTaskItem(String taskType, List<String> serverList) throws Exception;

  /**
   * ��ȡ���е���Ч��������Ϣ
   */
  public List<ScheduleServer> selectAllValidScheduleServer(String taskType) throws Exception;

  public List<String> loadScheduleServerNames(String taskType) throws Exception;

  /**
   * ���·�������Item
   */
  public void assignTaskItem(String taskType, String currentUuid, int maxNumOfOneServer,
      List<String> serverList) throws Exception;

  /**
   * ����������Ϣ
   */
  public boolean refreshScheduleServer(ScheduleServer server) throws Exception;

  /**
   * ע�������
   */
  public void registerScheduleServer(ScheduleServer server) throws Exception;

  /**
   * ע��������
   */
  public void unRegisterScheduleServer(String taskType, String serverUUID) throws Exception;

  /**
   * ����Ѿ����ڵ�OWN_SIGN���Զ����ɵ�����
   *
   * @param baseTaskType ��������
   * @param serverUUID ������
   * @param expireDateInternal ����ʱ�䣬����Ϊ��λ
   */
  public void clearExpireTaskTypeRunningInfo(String baseTaskType, String serverUUID,
      double expireDateInternal) throws Exception;

  public boolean isLeader(String uuid, List<String> serverList);

  public void pauseAllServer(String baseTaskType) throws Exception;

  public void resumeAllServer(String baseTaskType) throws Exception;

  public List<ScheduleTaskType> getAllTaskTypeBaseInfo() throws Exception;

  /**
   * ���һ���������͵���������Ϣ
   */
  public void clearTaskType(String baseTaskType) throws Exception;

  /**
   * ����һ���µ���������
   */
  public void createBaseTaskType(ScheduleTaskType baseTaskType) throws Exception;

  public void updateBaseTaskType(ScheduleTaskType baseTaskType) throws Exception;

  public List<ScheduleTaskTypeRunningInfo> getAllTaskTypeRunningInfo(String baseTaskType)
      throws Exception;

  /**
   * ɾ��һ����������
   */
  public void deleteTaskType(String baseTaskType) throws Exception;

  /**
   * ����������ѯ��ǰ���ȷ���
   */
  public List<ScheduleServer> selectScheduleServer(String baseTaskType, String ownSign, String ip,
      String orderStr)
      throws Exception;

  /**
   * ��ѯ���ȷ������ʷ��¼
   */
  public List<ScheduleServer> selectHistoryScheduleServer(String baseTaskType, String ownSign,
      String ip, String orderStr)
      throws Exception;

  public List<ScheduleServer> selectScheduleServerByManagerFactoryUUID(String factoryUUID)
      throws Exception;

  /**
   * ���������ע�����е� CurrentSever��RequestServer����������
   */
  public void createScheduleTaskItem(ScheduleTaskItem[] taskItems) throws Exception;

  /**
   * ���������״̬�ʹ�����Ϣ
   */
  public void updateScheduleTaskItemStatus(String taskType, String taskItem,
      ScheduleTaskItem.TaskItemSts sts, String message) throws Exception;

  /**
   * ɾ��������
   */
  public void deleteScheduleTaskItem(String taskType, String taskItem) throws Exception;

  /**
   * ��ʼ��������ȵ�����Ϣ�;�̬������Ϣ
   */
  public void initialRunningInfo4Static(String baseTaskType, String ownSign, String uuid)
      throws Exception;

  public void initialRunningInfo4Dynamic(String baseTaskType, String ownSign) throws Exception;

  /**
   * ��������Ϣ�Ƿ��ʼ���ɹ�
   */
  public boolean isInitialRunningInfoSucuss(String baseTaskType, String ownSign) throws Exception;

  public void setInitialRunningInfoSucuss(String baseTaskType, String taskType, String uuid)
      throws Exception;

  public String getLeader(List<String> serverList);

  public long updateReloadTaskItemFlag(String taskType) throws Exception;

  public long getReloadTaskItemFlag(String taskType) throws Exception;

}
