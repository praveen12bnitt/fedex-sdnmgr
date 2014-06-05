Ext.define('SdnMgr.view.CustomerInstanceModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.customerinstance',

    requires: [
        'SdnMgr.model.CustomerInstance'
    ],

    formulas: {
        typeFilter: function (get) {
            var category = get('category');
            return this.filters[category];
        }
    },

    filters: {
        all:   [ 'application', 'mda', 'mip'],
        application:  [ 'application' ],
        mda: [ 'mda' ],
        mip: [ 'mip' ]
    },

    stores: {
        customerinstance: {
            type: 'customerinstance',
            autoLoad: true
        }
    }
});
