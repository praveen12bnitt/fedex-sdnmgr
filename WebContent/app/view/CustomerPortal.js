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
                        '<img class="dataview-image" src="resources/icons/customer/{logo}" />',
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
                fields: ['name', 'shortname', 'logo', 
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
        };

        this.callParent(arguments);
    },
    
    showInstanceDetail: function(record) {
        this.up('panel#cardPanel').getLayout().setActiveItem('customerDetail');
        
        var customerDetailCard =  this.up('panel#cardPanel').getComponent('customerDetail');
        var logo = customerDetailCard.down('container image');
        var src = 'resources/icons/customer/' + record.get('logo');
        logo.setSrc(src);
        
        var primaryEmail = customerDetailCard.down('container displayfield#primaryEmail');
        var contactEmail = record.data.contact && record.data.contact.primaryEmail;
        primaryEmail.setValue(contactEmail);
        
        var primaryPhone = customerDetailCard.down('container displayfield#primaryPhone');
        var contactPhone = record.data.contact && record.data.contact.primaryPhone;
        primaryPhone.setValue(contactPhone);
        
        var preferredContactMode = customerDetailCard.down('container displayfield#preferredContactMode');
        var contactMode = record.data.contact && record.data.contact.preference;
        preferredContactMode.setValue(contactMode);
        
    }
});
