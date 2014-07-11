Ext.define('SdnMgr.view.CustomerInstanceController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.customerinstance',

    init: function (view) {
        // We provide the updater for the activeState config of our View.
        view.updateActiveState = this.updateActiveState.bind(this);
    },

    onCustomerInstanceClick: function(btn, menuitem) {
        var view = this.getView();
        view.setActiveState(menuitem.type);
    },

    renderTitleColumn: function (value, metaData, record) {
        var view = this.getView(),
            plugin = view.getPlugin('rowexpander'),
            tpl = view.titleTpl;

        if (!tpl.isTemplate) {
            view.titleTpl = tpl = new Ext.XTemplate(tpl);
        }

        var data = Ext.Object.chain(record.data);

        data.expanded = plugin.recordsExpanded[record.internalId] ? ' style="display: none"' : '';

        return tpl.apply(data);
    },

    updateActiveState: function (activeState) {
        var viewModel = this.getViewModel();
        var filterButton = this.lookupReference('filterButton');

        filterButton.setActiveItem(activeState);
        viewModel.set('category', activeState);

        //this.fireEvent('changeroute', this, 'customerinstance/' + activeState);
    },


    onClick: function(dv, record, item, index, e) {
    	var store = Ext.getStore('FixPacks');
    	var url = 'api/sdn/listSDNsForCustAppInst';
    	url = url + "/" + record.get('custId') + "/" + record.get('name');    	
    	store.getProxy().setUrl(url);
    	store.load();    	
    	
    },

    onExpandBody: function (rowNode) {   // , record, expandRow, eOpts
        Ext.fly(rowNode).addCls('x-grid-row-expanded');
        Ext.fly(rowNode).down('.instance-expand-data').enableDisplayMode().show();
    },

    onCollapseBody: function (rowNode) {  //, record, expandRow, eOpts
        Ext.fly(rowNode).removeCls('x-grid-row-expanded');
        Ext.fly(rowNode).down('.instance-expand-data').enableDisplayMode().hide();
    }
});
