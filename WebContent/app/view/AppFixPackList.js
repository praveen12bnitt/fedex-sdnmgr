Ext.define('SdnMgr.view.AppFixPackList',{
	extend: 'Ext.grid.Panel',
	title: 'All Fix Packs',
	xtype: 'appfixpacks',
	autoScroll: true,
	plugins: [ {
		ptype: 'rowexpander',
		rowBodyTpl : [
             '<p style="font-weight:bold;color:green;">Applied Apps:</p>',
             '<tpl if="Ext.isDefined(appliedApps) && appliedApps.length &gt; 0">',
             	'<tpl for="appliedApps">',
          			'<p>{.}</p>',
          		'</tpl>',
   			 '<tpl else>',
   				'<p>-None-</p>',
	  		 '</tpl>',
	  		 '<p style="font-weight:bold;color:red;">Pending Apps:</p>',
	  		 '<tpl if="Ext.isDefined(pendingApps) && pendingApps.length &gt; 0">',
	         	'<tpl for="pendingApps">',
	      			'<p>{.}</p>',
	      		'</tpl>',
			 '<tpl else>',
					'<p>-None-</p>',
	  		 '</tpl>'
        ]
	}],
	store: Ext.create('SdnMgr.store.AppFixPacks'),
	columns: [{
        	  text: 'Fix Pack Name',
        	  dataIndex: 'name',
        	  flex: 1
          }, {
        	  text: 'Product Name',
        	  dataIndex: 'productName',
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
        	  dataIndex: 'appliedApps',
        	  xtype: 'templatecolumn',
        	  tpl: new Ext.XTemplate('<tpl if="Ext.isDefined(appliedApps)">',
              			'{appliedApps.length}',
              		'<tpl else>',
              		'0',
        	  		'</tpl>'),
        	  flex: 3/4
          }, {
        	  text: 'Apps Pending',
        	  dataIndex: 'pendingApps',
        	  flex: 3/4,
        	  xtype: 'templatecolumn',
        	  tpl: new Ext.XTemplate('<tpl if="Ext.isDefined(pendingApps)">',
              			'{pendingApps.length}',
              		'<tpl else>',
                  		'0',
            	  	'</tpl>'),
          }, {
        	  text: 'Description',
        	  dataIndex: 'desc',
        	  flex: 3
          }
	]
});