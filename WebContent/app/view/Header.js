Ext.define('SdnMgr.view.Header', {
    extend: 'Ext.Container',
    alias: 'widget.appHeader',
    itemId: 'app-header',
    cls: 'header',    
    height: 40,
    layout: {
        type: 'hbox',
        align: 'middle'
    },

    initComponent: function() {
        this.items = [{
            xtype: 'label',
            itemId: 'app-header-title',
            cls: 'app-header-text',
            text: 'SDN Manager',
            flex: 1
        }];

        this.callParent(arguments);
    }
});
