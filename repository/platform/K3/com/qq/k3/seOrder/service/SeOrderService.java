package com.qq.k3.seOrder.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

import com.qq.k3.seOrder.dao.SeOrderDao;
import com.qq.k3.seOrder.dao.SeOrderEntryDao;
import com.qq.k3.seOrder.entity.SeOrder;
import com.qq.k3.seOrder.entity.SeOrderEntry;
import com.qq.k3.seOrder.entity.SeOrderId;
import com.thinkgem.jeesite.common.hibernate.persistence.BaseServiceHBT;

@Service("seorderService")
@Transactional(readOnly = true)
public class SeOrderService extends BaseServiceHBT<SeOrder, SeOrderDao>
{
	private static final long serialVersionUID = 1L;

	@Autowired
	SeOrderEntryDao seorderEntryDao;

	@Transactional(readOnly = true)
	public SeOrder findById(SeOrderId seorderId)
		{

			SeOrder instance = super.dao.findById(seorderId);

			for (SeOrderEntry seorderEntry : instance.getSeorderEntries())
			{
				seorderEntry.setSeorder(instance);

			}
			return instance;

		}
	
	
	/*
	 * 由于web页面省去很多属性值，重载add()方法
	 * 
	 */
	 @Override
	@Transactional(readOnly = true)
	public void add(SeOrder seorder)
		{

			// 1.seorder非空属性补全

			seorder.setFcurrencyId(1);
			seorder.setFfetchStyle("");
			seorder.setFsaleStyle(101);
			seorder.setFclosed((short) 0);
			seorder.setFtranType(81);
			seorder.setFinvoiceClosed((short) 0);
			seorder.setFbclosed((short) 0);
			seorder.setFsettleId(0);
			seorder.setFexchangeRate((double) 1);
			seorder.setFdiscountType(false); 
			seorder.setFcancellation(false);
			seorder.setFtransitAheadTime((float) 0);
			seorder.setFpoordBillNo("");
			seorder.setFrelateBrId(0);
			seorder.setFimport(0);
			seorder.setForderAffirm(0);
			seorder.setFtranStatus(0);
			if(seorder.getFuuid()==null)
			seorder.setFuuid(UUID.randomUUID().toString());
			byte[] foperDate = null;
			seorder.setFoperDate(foperDate);
			seorder.setFsystemType(1);
			seorder.setFcashDiscount("");
			seorder.setFsettleDate(new Date());
			seorder.setFselTranType(0);
			seorder.setFchildren(0);
			seorder.setFbrId(0);
			seorder.setFareaPs(20302);
			seorder.setFclassTypeId(0);
			seorder.setFmanageType(0);
			seorder.setFsysStatus((short) 2);

			

			for (SeOrderEntry seorderEntry : seorder.getSeorderEntries())
			{
				
				// 1.seorderEntry非空属性补全 
				seorderEntry.setFcommitQty((double) 0);
				seorderEntry.setFtaxRate((double) 0);
				seorderEntry.setFtaxAmount((double) 0);
				seorderEntry.setFtax((double) 0);
				seorderEntry.setFinvoiceQty((double) 0);
				seorderEntry.setFbcommitQty((double) 0);
				seorderEntry.setFtranLeadTime(0);
				seorderEntry.setFatpdeduct(0);
				seorderEntry.setFcostObjectId(0);
				seorderEntry.setFauxBcommitQty((double) 0);
				seorderEntry.setFauxCommitQty((double) 0); 
				seorderEntry.setFauxInvoiceQty((double) 0);
				seorderEntry.setFuniDiscount((double) 0);
				seorderEntry.setFfinalAmount((double) 0);
				seorderEntry.setFsourceEntryId(0);
				seorderEntry.setFhaveMrp(0);
				seorderEntry.setFstockQty((double) 0);
				seorderEntry.setFauxStockQty((double) 0);
				seorderEntry.setFbatchNo("");
				seorderEntry.setFcess((double) 0);
				seorderEntry.setFbomInterId(0);
				seorderEntry.setFmapNumber("");
				seorderEntry.setFmapName("");
				seorderEntry.setFlockFlag(0);
				seorderEntry.setFinForeCast(0);
				seorderEntry.setFauxPropId(0);
				seorderEntry.setFqtyInvoice((double) 0);
				seorderEntry.setFqtyInvoiceBase((double) 0);
				seorderEntry.setFtaxAmt((double) 0);
				seorderEntry.setFreceiveAmountForCommit((double) 0);
				seorderEntry.setFreceiveAmountCommit((double) 0);
				seorderEntry.setFsecCoefficient((double) 0);
				seorderEntry.setFsecQty((double) 0);
				seorderEntry.setFsecCommitQty((double) 0);
				seorderEntry.setFsourceTranType(0);
				seorderEntry.setFsourceInterId(0);
				seorderEntry.setFsourceBillNo("");
				seorderEntry.setFcontractInterId(0);
				seorderEntry.setFcontractEntryId(0);
				seorderEntry.setFcontractBillNo("");
				seorderEntry.setFmrplockFlag(0);
				seorderEntry.setFmrptrackFlag(0);
				seorderEntry.setForderCommitQty((double) 0);
				seorderEntry.setForderSecCommitQty((double) 0);
				seorderEntry.setFauxQtyInvoice((double) 0);
				seorderEntry.setFcommitInstall((double) 0);
				seorderEntry.setFauxCommitInstall((double) 0);
				seorderEntry.setFmrpClosed(0);
				seorderEntry.setFauxInCommitQty((double) 0);
				seorderEntry.setFinCommitQty((double) 0);
				seorderEntry.setFsecInCommitQty((double) 0);
				seorderEntry.setFapplyCommitQty((double) 0);
				seorderEntry.setFauxApplyCommitQty((double) 0);
				seorderEntry.setFsecApplyCommitQty((double) 0);
				seorderEntry.setFevaluated(0);
				seorderEntry.setFpackUnitId(0);
				seorderEntry.setFpackCount(0);
				seorderEntry.setFpackType((double) 0);
				seorderEntry.setFmapId(0);
				seorderEntry.setFgoodsDesc("");
				seorderEntry.setFamountAfterDiscount((double) 0);
				seorderEntry.setFinformCommitQty((double) 0);
				seorderEntry.setFauxInformCommitQty((double) 0);
				seorderEntry.setFsecInformCommitQty((double) 0);
				seorderEntry.setFpurCommitQty((double) 0);
				seorderEntry.setFauxPurCommitQty((double) 0);
				seorderEntry.setFsecPurCommitQty((double) 0);
				seorderEntry.setFmrpAutoClosed(0);
				seorderEntry.setFsecStockQty((double) 0);
				seorderEntry.setFsecInvoiceQty((double) 0);
				seorderEntry.setFsecCommitInstall((double) 0);
				seorderEntry.setFplanMode(14036);
				seorderEntry.setFmtono("");
				
				
				
				
				
				
				// 1.seorderEntry属性联动
				seorderEntry.setFauxPrice(seorderEntry.getFprice() );
				seorderEntry.setFauxQty(seorderEntry.getFqty());
				seorderEntry.setFadviceConsignDate(new Date());
				seorderEntry.setFallAmount(seorderEntry.getFamount());
				seorderEntry.setFallStdAmount(seorderEntry.getFamount());
				seorderEntry.setFauxPriceDiscount(seorderEntry.getFprice());
				seorderEntry.setFpriceDiscount(seorderEntry.getFprice());
				seorderEntry.setFauxTaxPrice(seorderEntry.getFprice());
				seorderEntry.setFtaxPrice(seorderEntry.getFprice());
				seorderEntry.setSeorder(seorder);
				seorderEntry.setFdate(seorder.getFdate());
				
			}
			
			
			super.saveOrUpdate(seorder);
		}

	 

}