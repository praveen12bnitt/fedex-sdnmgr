Ext.define('SdnMgr.view.CustomerDetail', {
    extend: 'Ext.panel.Panel',

    requires: [
        'Ext.Img',
        'Ext.button.Button',
        'Ext.grid.Panel',
        'Ext.grid.column.Action',
        'Ext.grid.View'
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
                            cls: 'logo-container',
                            itemId: 'logoContainer',
                            items: [
                                {
                                    xtype: 'image',
                                    height: 100,
                                    itemId: 'companyImage',
                                    width: 100,
                                    src: 'resources/icons/homedepot.png'
                                }
                            ]
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