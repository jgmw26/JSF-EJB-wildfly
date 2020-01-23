/**
 * 
 */
function myFunction() {
    confirm("Deseja realmente excluir?");
  }
{
	$(document).ready(function() {
	    $("#myInput").on("keyup", function() {
	        var value = $(this).val().toLowerCase();
	        $("#myTable tr").filter(function() {
	            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	        });
	    });
	});
}
{
	//Material Select Initialization
	$(document).ready(function() {
	$("#mdb-select").materialSelect();
	});
}
{
	$('#keep-order').multiSelect({ keepOrder: true });
}

$('.searchable').multiSelect({
	  selectableHeader: "<input type='text' class='search-input' autocomplete='off' placeholder='try \"12\"'>",
	  selectionHeader: "<input type='text' class='search-input' autocomplete='off' placeholder='try \"4\"'>",
	  afterInit: function(ms){
	    var that = this,
	        $selectableSearch = that.$selectableUl.prev(),
	        $selectionSearch = that.$selectionUl.prev(),
	        selectableSearchString = '#'+that.$container.attr('id')+' .ms-elem-selectable:not(.ms-selected)',
	        selectionSearchString = '#'+that.$container.attr('id')+' .ms-elem-selection.ms-selected';

	    that.qs1 = $selectableSearch.quicksearch(selectableSearchString)
	    .on('keydown', function(e){
	      if (e.which === 40){
	        that.$selectableUl.focus();
	        return false;
	      }
	    });

	    that.qs2 = $selectionSearch.quicksearch(selectionSearchString)
	    .on('keydown', function(e){
	      if (e.which == 40){
	        that.$selectionUl.focus();
	        return false;
	      }
	    });
	  },
	  afterSelect: function(){
	    this.qs1.cache();
	    this.qs2.cache();
	  },
	  afterDeselect: function(){
	    this.qs1.cache();
	    this.qs2.cache();
	  }
	});