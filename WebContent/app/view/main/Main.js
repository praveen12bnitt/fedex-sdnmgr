Ext.define('SdnMgr.view.main.Main', {
    extend: 'Ext.container.Viewport',
    
    requires: [
        'Ext.panel.Panel',
        'Ext.grid.Panel'
    ],
    
    layout: {
        type: 'border'
    },

    items: [{
        xtype: 'appHeader',
        region: 'north'
    },{
        region: 'center',
        xtype: 'panel',
        itemId: 'cardPanel',
        bodyPadding: 10,
        layout: 'card',
        items: [{
            xtype: 'customer.dataview',
            itemId: 'customerView'
        }, {
            xtype: 'customer.detail',
            itemId: 'customerDetail'
        }]
    }]
});
