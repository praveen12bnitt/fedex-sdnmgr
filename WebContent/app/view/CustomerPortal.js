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
        me.items = {
            xtype: 'dataview',
            margin: 20,
            cls: 'dataview',
            tpl: [
                '<tpl for=".">',
                    '<div class="dataview-multisort-item">',
                        '<img class="dataview-image" src="resources/icons/customer/{thumb}" />',
                        '<span class="dataview-text">{name}</span>',
                    '</div>',
                '</tpl>'
            ],
            listeners: {
                select: function(dataview, record) {
                    me.showInstanceDetail(record);
                }
            },
            itemSelector: 'div.dataview-multisort-item',
            store: Ext.create('Ext.data.Store', {
                autoLoad: true,
                sortOnLoad: true,
                fields: ['name', 'thumb', 'fixpackCount'],
                proxy: {
                    type: 'ajax',
                    url : 'resources/data/customers.json',
                    reader: {
                        type: 'json',
                        rootProperty: ''
                    }
                }
            })
        };

        this.callParent(arguments);
    },
    
    showInstanceDetail: function(record) {
        this.up('panel#cardPanel').getLayout().setActiveItem('customerDetail');
    }
});
