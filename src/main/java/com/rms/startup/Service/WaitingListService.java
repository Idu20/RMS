package com.rms.startup.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.startup.Messages;
import com.rms.startup.Bean.CustomerBean;
import com.rms.startup.Bean.WaitingListBean;
import com.rms.startup.DAO.CustomerDAO;
import com.rms.startup.DAO.WaitingListDAO;
import com.rms.startup.Entities.CustomerEntity;

@Service
public class WaitingListService {

	@Autowired
	WaitingListDAO dao;

	@Autowired
	CustomerDAO customerDAO;

	public List<WaitingListBean> getAllWaitingList() {
		return dao.getAllWaitingList();
	}

	public String addWaitingList(WaitingListBean bean) {
		CustomerBean customerBean = customerDAO.getCustomer(bean.getCustomerBean().getMobileNumber());
		CustomerEntity entity = new CustomerEntity(customerBean);
		if (dao.findCustomer(entity).size() == 0) {
			dao.addWaitingList(bean);
			return Messages.added;
		}
		return Messages.alreadyExist;

	}

	public String deleteWaitingList(Integer waitingNumber) {
		dao.deleteWaitingList(waitingNumber);
		return Messages.deleted;
	}

	public WaitingListBean getWaitingList(Integer waitingNumber) {
		return dao.getWaitingList(waitingNumber);
	}

	public String updateWaitingList(WaitingListBean bean) {
		dao.updateWaitingList(bean);
		return Messages.updated;
	}

}
