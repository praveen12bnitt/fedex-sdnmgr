Ext.define('SdnMgr.view.CustomerDetail', {
    extend: 'Ext.panel.Panel',

    requires: [
        'Ext.Img',
        'Ext.button.Button',
        'Ext.grid.Panel',
        'Ext.grid.column.Action',
        'Ext.grid.View',
        'Ext.form.field.Display',
        'SdnMgr.view.AppFixPackList'
    ],
    
    xtype: 'customer.detail',
    
    border: false,

    itemId: 'customerDetail',
    layout: 'border',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
                    region: 'north',
                    height: 80,
                    itemId: 'customerDetailHdr',
                    cls: 'instance-hdr',
                    layout: {
                        type: 'hbox',
                        align: 'stretch'
                    },
                    items: [
                        {
                            xtype: 'container',
                            itemId: 'logoContainer',
                            flex: 1,
                            items: [
                                {
                                    xtype: 'image',
                                    itemId: 'companyImage',
                                    width: 80,
                                    height: 80
                                }
                            ]
                        }, 
                        {
                            xtype: 'container',
                            itemId: 'primary',
                            flex: 1.2,
                            items: [
                                {
                                    xtype: 'image',
                                    itemId: 'primaryImage',
                                    src: 'resources/icons/primary.png'
                                }
                            ]
                        },
                        {
                            xtype: 'container',
                            flex: 8,
                            padding: 15,
                        	margin: '0 15',
                            layout: {
                                type: 'table',
                                columns: 2,
                                tableAttrs: {
                                    style: {
                                        width: '100%'
                                    }
                                },
                                tdAttrs: {
                                    style: {
                                        width: '50%'
                                    }
                                }
                                
                            },
                            items: [{
                                    xtype: 'displayfield',
                                    fieldLabel: 'NAME',
                                    itemId: 'primaryName',
                                    labelWidth: 250,
                                    labelCls: 'customer-contact-info',
                                    fieldCls: 'customer-contact-info'
                                },
                                {
                                    xtype: 'displayfield',
                                    labelWidth: 250,
                                    fieldLabel: 'NUMBER',
                                    itemId: 'primaryPhone',
                                    labelCls: 'customer-contact-info',
                                    fieldCls: 'customer-contact-info'
                                },
                                {
                                    xtype: 'displayfield',
                                    labelWidth: 250,
                                    fieldLabel: 'EMAIL ADDRESS',
                                    itemId: 'primaryEmail',
                                    labelCls: 'customer-contact-info',
                                    fieldCls: 'customer-contact-info'
                                }, 
                                {
                                    xtype: 'displayfield',
                                    labelWidth: 250,
                                    fieldLabel: 'MODE',
                                    itemId: 'preferredContactMode',
                                    labelCls: 'customer-contact-info',
                                    fieldCls: 'customer-contact-info'
                            }]
                        }
                    ]
                },
                {
                    xtype: 'tabpanel',
                    cls: 'customer-tab-view',
                    region: 'center',
                    itemId: 'customerTab',
                    items: [{
	                    itemId: 'customerDetailView',
	                    title: 'Customer Details',
	                    layout: 'fit',
	                    items: [{
	                    	xtype: 'container',
	                    	layout: {
	                    		type: 'hbox',
	                    		align: 'stretch'
	                    	},
	                    	items: [{
	                    		xtype: 'appinstance.view',
	                    		margin: 5,
	                    		flex: 1
	                    	}, {
	                    		xtype: 'appinstance.detail',
	                    		margin: 5,
	                    		flex: 1
	                    	}
	                    	]
	                    }]
                    }, {
                    	title: 'Fix Packs List',
                    	xtype: 'appfixpacks',
                    	listeners: {
                    		activate: function(pnl) {
                    			var store = Ext.getStore('AppFixPacks');
                    	    	var url = 'api/sdn/listSdnsForCustomer';
                    	    	url = url + "/" + pnl.custRecord.get('id');
                    	    	store.getProxy().setUrl(url);
                    	    	store.load();
                    		}
                    	}
                    }]                            
                }
            ]
        });

        me.callParent(arguments);
    }

});