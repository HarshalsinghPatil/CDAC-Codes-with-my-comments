global using Microsoft.EntityFrameworkCore;

namespace DemoApp.Shopping;
//DBcontext may have one or more than one DBSets (Which represent the tables in the databases).And we use LINQ queries to query this dbsets and EFC translates this queries in to the SQL  queries at runtime. EFC keeps track of all the changes made to the DBSets
public class ShopDbContext : DbContext
{//DbSet<TEntity> which is called as the set of entity.
    public DbSet<Product> Products { get; set; }

    public DbSet<Order> Orders { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseSqlServer("Server=(localdb)\\METIIT;Database=Shop");
    }
//when we are not using the annotations we need to use the model builder for mapping
    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {// ModelBuilder = uses the conventions to create primary keys, Foreign keys, relationships etc.
        modelBuilder.Entity<Product>()
            .ToTable("ProductInfo")
            .Property(p => p.Id)
            .HasColumnName("ProductNo");
        modelBuilder.Entity<Order>()
            .ToTable("OrderDetail")
            .Property(p => p.Id)
            .HasColumnName("OrderNo");
        modelBuilder.Entity<Order>()
            .Property(p => p.ProductId)
            .HasColumnName("ProductNo");
    }
}