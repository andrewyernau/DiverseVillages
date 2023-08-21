package net.andrewyernau.tutorialmod.block.custom;

import net.andrewyernau.tutorialmod.block.entity.ModBlockEntities;
import net.andrewyernau.tutorialmod.block.entity.WizardTableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class WizardTable extends BaseEntityBlock {
    public static DirectionProperty FACING= BlockStateProperties.HORIZONTAL_FACING;
    public WizardTable(Properties properties) {
        super(properties);
    }
    private final VoxelShape SHAPE= Stream.of(Block.box(0, 0, 0, 16, 14, 16)).reduce((voxelShape, voxelShape2) -> Shapes.join(voxelShape,voxelShape2,BooleanOp.OR)).get();

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState>builder){
        builder.add(FACING);
    }
    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation){
        return blockState.setValue(FACING,rotation.rotate(blockState.getValue(FACING)));
    }
    @Override
    public BlockState mirror(BlockState blockState, Mirror mirror){
        return blockState.rotate(mirror.getRotation(blockState.getValue(FACING)));
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext){
        return this.defaultBlockState().setValue(FACING,placeContext.getHorizontalDirection().getOpposite());
    }
    /*BLOCK ENTITY*/

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState newBlockState, boolean isMoving) {
        if (blockState.getBlock()!=newBlockState.getBlock()){
            BlockEntity blockEntity=level.getBlockEntity(blockPos);
            if (blockEntity instanceof WizardTableBlockEntity){
                ((WizardTableBlockEntity)blockEntity).drops();
            }
        }
        super.onRemove(blockState, level, blockPos, newBlockState, isMoving);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (!level.isClientSide()){
            BlockEntity entity=level.getBlockEntity(blockPos);
            if(entity instanceof WizardTableBlockEntity){
                NetworkHooks.openScreen(((ServerPlayer) player),(WizardTableBlockEntity)entity,blockPos);

            }else{
                throw new IllegalStateException("Container provider is missing!");
            }

        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new WizardTableBlockEntity(pos,state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.WIZARD_TABLE.get(),WizardTableBlockEntity::tick);
    }
}
