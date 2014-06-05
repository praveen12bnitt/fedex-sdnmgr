Ext.define('SdnMgr.view.CustomerAppInstance', {
    extend: 'Ext.grid.Panel', 
    xtype: 'appinstance.view',
    cls: 'customer-instance-grid',
    
    itemId: 'customerAppInstance',
    
    layout: 'fit',
    
    requires: [
        'Ext.grid.plugin.RowExpander',
        'SdnMgr.ux.plugin.RowExpander',
        'SdnMgr.view.CustomerInstanceController',
        'SdnMgr.view.CustomerInstanceModel'
    ],
    
    config: {
        activeState: null,
        defaultActiveState: 'all'
    },
    
    controller: 'customerinstance',

    viewModel: {
        type: 'customerinstance'
    },
    
    hideHeaders: true,
    
    bind: '{customerinstance}',

    tbar: [{
        text: 'All Instances',
        xtype: 'cycle',
        reference: 'filterButton',
        cls: 'filterbutton',
        showText: true,
        width: 150,
        textAlign: 'left',

        listeners: {
            change: 'onCustomerInstanceClick'
        },

        menu: {
            id: 'customer-instance-menu',
            items: [{
                text: 'All Instances',
                type: 'all',
                itemId: 'all',
                checked: true
            },{
                text: 'Application',
                type: 'application',
                itemId: 'application'
            },{
                text: 'MDA',
                type: 'mda',
                itemId: 'mda'
            }, {
                text: 'MIP',
                type: 'mip',
                itemId: 'mip'
            }]
        }
    }],
    
   columns: [{
        dataIndex: 'title',
        flex: 1,
        renderer: 'renderTitleColumn'
    }],
    
    titleTpl:
        '<div class="text-wrapper">' +
            '<div class="news-icon {type}">&nbsp;</div>' +
            '<div class="instance-data">' +
                '<div class="instance-content">' +
                    '<div class="instance-title">{name}</div>' +
                    '<div class="instance-small">{hostname}</div>' +
                    '<div class="instance-small">{port}</div>' +
                '</div>' +
	            '<div class="sdn-data">' +
	                '<div class="sdn-applied">Applied {applied}</div>' +
	                '<div class="sdn-pending">Pending {pending}</span></div>' +
	            '</div>' +
            '</div>' +
        '<div>',

    viewConfig: {
        listeners: {
            itemclick: 'onClick',
            expandbody: 'onExpandBody',
            collapsebody: 'onCollapseBody'
        }
    },

    plugins: [{
        ptype: 'ux-rowexpander',
        pluginId: 'rowexpander'
    }],
    
    validStates: {
        all: 1,
        application: 1,
        mda: 1,
        mip: 1
    },

    isValidState: function (state) {
        return state in this.validStates;
    }
   
});