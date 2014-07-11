Ext.define('SdnMgr.view.AppFixPackList',{
	extend: 'Ext.grid.Panel',
	title: 'All Fix Packs',
	xtype: 'appfixpacks',
	store: Ext.create('SdnMgr.store.AppFixPacks'),
	columns: [{
        	  text: 'Product Name',
        	  dataIndex: 'productName',
        	  flex: 1
          }, {
        	  text: 'Fix Pack Name',
        	  dataIndex: 'name',
        	  flex: 1
          }, {
        	  text: 'Publish Date',
        	  dataIndex: 'publishDate',
        	  flex: 1,
        	  renderer : function(value) {
        		  return Ext.Date.format(new Date(value), 'm/d/Y H:i:s');
        	  }
          }, {
        	  text: 'Apps Applied',
        	  dataIndex: 'appNames',
        	  flex: 1
          }, {
        	  text: 'Apps Pending',
        	  dataIndex: 'appNames',
        	  flex: 1
          }
	]
});