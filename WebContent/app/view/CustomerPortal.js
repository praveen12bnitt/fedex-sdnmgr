Ext.define('SdnMgr.view.CustomerPortal', {
    extend: 'Ext.panel.Panel',
    
    cls: 'customerview',

    requires: [
        'Ext.toolbar.TextItem',
        'Ext.view.View'
    ],

    xtype: 'customer.dataview',
    title: '<span class="title">CUSTOMER PORTAL</title>',
    layout: 'fit',
    border: false,
    
    initComponent: function() {
        var me = this;
        me.items = [{
            xtype: 'dataview',
            margin: 20,
            cls: 'dataview',
            tpl: new Ext.XTemplate(
                '<tpl for=".">',
                    '<div class="dataview-multisort-item">',
                    	'<img class="dataview-image" src="resources/icons/customer/{logo}" />',
                    		'<tpl if="pendingCount &gt; 0">',
                    			'<img class="dataview-alert-image" src="resources/icons/alert.png" />',
                    		'</tpl>',
                        '<span class="dataview-text">{name}</span>',
                    '</div>',
                '</tpl>'
            ),
            listeners: {
                itemclick: function(dataview, record) {
                    me.showInstanceDetail(record);
                }
            },
            itemSelector: 'div.dataview-multisort-item',
            store: Ext.create('Ext.data.Store', {
                autoLoad: true,
                sortOnLoad: true,
                fields: ['id','name', 'shortname', 'logo', 
                         {name: 'contact', type: 'auto'}],
                proxy: {
                    type: 'rest',
                    url : 'api/sdn/listCustomers',
                    reader: {
                        type: 'json',
                        rootProperty: ''
                    }
                }
            })
        }];

        this.callParent(arguments);
    },
    
    showInstanceDetail: function(record) {
    	
    	var cardPanel = this.up('panel#cardPanel');
    	cardPanel.getLayout().setActiveItem('customerDetail');
    	var customerTab = cardPanel.down('#customerTab');
    	customerTab.setActiveItem(0);
        
        //setting the header details
        var customerDetailCard =  cardPanel.getComponent('customerDetail');
        var logo = customerDetailCard.down('container image');
        var src = 'resources/icons/customer/' + record.get('logo');
        logo.setSrc(src);
        
        var primaryEmail = customerDetailCard.down('container displayfield#primaryEmail');
        var contactEmail = record.data.contact && record.data.contact.primaryEmail;
        primaryEmail.setValue(contactEmail);
        
        var primaryName = customerDetailCard.down('container displayfield#primaryName');
        var name = record.data.contact && record.data.contact.primaryName;
        primaryName.setValue(name);
        
        var primaryPhone = customerDetailCard.down('container displayfield#primaryPhone');
        var contactPhone = record.data.contact && record.data.contact.primaryPhone;
        primaryPhone.setValue(contactPhone);
        
        var preferredContactMode = customerDetailCard.down('container displayfield#preferredContactMode');
        var contactMode = record.data.contact && record.data.contact.preference;
        preferredContactMode.setValue(contactMode);
        
        // load all the instances associated with the customer
        var instancesGrid = customerDetailCard.down('panel#customerDetailView container gridpanel');
        var appFixPackPanel = customerDetailCard.down('panel[xtype=appfixpacks]');
        appFixPackPanel.custRecord = record;
        var appInstances = record.get('appInstances');
        var customerInstanceData = [];
        if(appInstances) {
        	
            for(var i in appInstances) {
            	var inst = appInstances[i];
            	var type = 'application';
            	if(inst.product == 'MDA') {
            		type = 'mda';
            	} else if (inst.product == 'MIP'){
            		type = 'mip';
            	}
            		
            	var cd = Ext.create('SdnMgr.model.CustomerInstance', {
            		hostname: inst.host,
            		name: inst.name,
            		release: inst.release,
            		port: inst.port,
            		url: inst.location,
            		type: type,
            		release: '2013',
            		applied: inst.appliedSdns && inst.appliedSdns.length,
            		pending: inst.pendingSdns && inst.pendingSdns.length,
            		custId: record.get('shortName')
            	});
            	customerInstanceData.push(cd);
            }
        }
        instancesGrid.getStore().loadData(customerInstanceData);
        var store = Ext.getStore('FixPacks');
        store.removeAll();
    }
});
