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

    itemId: 'customerDetail',
    layout: 'border',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
                    border: false,
                    region: 'north',
                    height: 80,
                    itemId: 'sidePanel',
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
                            layout: {
                                type: 'hbox',
                                align: 'stretch'
                            },
                            items: [{
                                xtype: 'container',
                                layout: {
                                    type: 'vbox'
                                },
                                items: [
                                {
                                    xtype: 'displayfield',
                                    fieldLabel: 'Primary Contact Name',
                                    itemId: 'primaryName',
                                    value: 'Kaveen Jagadeesan',
                                    labelCls: 'customer-contact-info',
                                    fieldCls: 'customer-contact-info'
                                },
                                {
                                    xtype: 'displayfield',
                                    fieldLabel: 'Primary Contact Number',
                                    itemId: 'primaryPhone',
                                    labelCls: 'customer-contact-info'
                                }]
                            },
                            {
                                xtype: 'container',
                                layout: {
                                    type: 'vbox'
                                },
                                items: [
                                {
                                    xtype: 'displayfield',
                                    fieldLabel: 'Primary Email Address',
                                    itemId: 'primaryEmail',
                                    labelCls: 'customer-contact-info',
                                    fieldCls: 'customer-contact-info'
                                }, {
                                    xtype: 'displayfield',
                                    fieldLabel: 'Preferred Contact Mode',
                                    itemId: 'preferredContactMode',
                                    labelCls: 'customer-contact-info',
                                    fieldCls: 'customer-contact-info'
                                }]
                            }]
                        }
                    ]
                },
                {
                    xtype: 'panel',
                    region: 'center',
                    itemId: 'customerCard',
                    layout: 'card',
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