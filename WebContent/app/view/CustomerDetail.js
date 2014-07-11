Ext.define('SdnMgr.view.CustomerDetail', {
    extend: 'Ext.panel.Panel',

    requires: [
        'Ext.Img',
        'Ext.button.Button',
        'Ext.grid.Panel',
        'Ext.grid.column.Action',
        'Ext.grid.View',
        'Ext.form.field.Display'
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
                            flex: 8,
                            padding: 10,
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
                                    fieldLabel: 'PRIMARY CONTACT NAME',
                                    itemId: 'primaryName',
                                    labelWidth: 250,
                                    labelCls: 'customer-contact-info',
                                    fieldCls: 'customer-contact-info'
                                },
                                {
                                    xtype: 'displayfield',
                                    labelWidth: 250,
                                    fieldLabel: 'PRIMARY CONTACT NUMBER',
                                    itemId: 'primaryPhone',
                                    labelCls: 'customer-contact-info',
                                    fieldCls: 'customer-contact-info'
                                },
                                {
                                    xtype: 'displayfield',
                                    labelWidth: 250,
                                    fieldLabel: 'PRIMARY EMAIL ADDRESS',
                                    itemId: 'primaryEmail',
                                    labelCls: 'customer-contact-info',
                                    fieldCls: 'customer-contact-info'
                                }, 
                                {
                                    xtype: 'displayfield',
                                    labelWidth: 250,
                                    fieldLabel: 'PREFERRED CONTACT MODE',
                                    itemId: 'preferredContactMode',
                                    labelCls: 'customer-contact-info',
                                    fieldCls: 'customer-contact-info'
                            }]
                        }
                    ]
                },
                {
                    xtype: 'panel',
                    region: 'center',
                    itemId: 'customerDetailView',
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
                            
                }
            ]
        });

        me.callParent(arguments);
    }

});